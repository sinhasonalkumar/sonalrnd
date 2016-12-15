/* Setup our aws provider */
provider "aws" {
  //access_key  = "${var.access_key}"
  //secret_key  = "${var.secret_key}"
  //shared_credentials_file = "${var.shared_credentials_file}"
  profile = "${var.profile}"

  region = "${var.region}"
}

/* Define our vpc */
resource "aws_vpc" "default" {
  cidr_block           = "${var.vpc_cidr}"
  enable_dns_hostnames = true

  tags {
    Name = "infra-as-code-tf-example"
  }
}

/* Internet gateway for the public subnet */
resource "aws_internet_gateway" "default" {
  vpc_id = "${aws_vpc.default.id}"

  tags {
    Name = "default-internet_gateway-${aws_vpc.default.id}"
  }
}

/* Public subnet */
resource "aws_subnet" "public" {
  vpc_id            = "${aws_vpc.default.id}"
  cidr_block        = "${var.public_subnet_cidr}"
  availability_zone = "us-west-2a"

  //map_public_ip_on_launch = true
  depends_on = ["aws_internet_gateway.default"]

  tags {
    Name = "publicSubnet-${aws_vpc.default.id}"
  }
}

/* Private subnet */
resource "aws_subnet" "private" {
  vpc_id            = "${aws_vpc.default.id}"
  cidr_block        = "${var.private_subnet_cidr}"
  availability_zone = "us-west-2a"

  tags {
    Name = "privateSubnet-${aws_vpc.default.id}"
  }
}

/* Routing table for public subnet */
resource "aws_route_table" "public" {
  vpc_id = "${aws_vpc.default.id}"

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_internet_gateway.default.id}"
  }

  tags {
    Name = "public-route_table-${aws_vpc.default.id}"
  }
}

/* Associate the routing table to public subnet */
resource "aws_route_table_association" "public" {
  subnet_id      = "${aws_subnet.public.id}"
  route_table_id = "${aws_route_table.public.id}"
}

resource "aws_eip" "natgw" {
  vpc = true
}

resource "aws_nat_gateway" "natgw" {
  allocation_id = "${aws_eip.natgw.id}"
  subnet_id     = "${aws_subnet.public.id}"
  depends_on    = ["aws_internet_gateway.default"]
}

/* Routing table for nat gateway */
resource "aws_route_table" "natgw" {
  vpc_id = "${aws_vpc.default.id}"

  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = "${aws_nat_gateway.natgw.id}"
  }

  tags {
    Name = "natgw-route_table-${aws_vpc.default.id}"
  }
}

/* Associate the routing table to public subnet */
resource "aws_route_table_association" "natgw" {
  subnet_id      = "${aws_subnet.private.id}"
  route_table_id = "${aws_route_table.natgw.id}"
}
