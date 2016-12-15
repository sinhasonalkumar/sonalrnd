/* Security group for the backend server */
resource "aws_security_group" "backend_server" {
  name        = "test backend_server"
  description = "Security group for web that allows web traffic from internet"
  vpc_id      = "${aws_vpc.default.id}"

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["${aws_vpc.default.cidr_block}"]
  }

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["${aws_vpc.default.cidr_block}"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags {
    Name = "backend_server-${aws_vpc.default.id}"
  }
}

/* Security group for ssh_anywhere */
resource "aws_security_group" "ssh_anywhere" {
  name        = "ssh_anywhere"
  description = "Security group for web that allows web traffic from internet"
  vpc_id      = "${aws_vpc.default.id}"

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags {
    Name = "ssh_anywhere-${aws_vpc.default.id}"
  }
}
