resource "aws_instance" "app" {
  count         = 1
  ami           = "${lookup(var.amis, var.region)}"
  instance_type = "t2.micro"
  subnet_id     = "${aws_subnet.private.id}"

  //security_groups = ["${aws_security_group.backend_server.id}"]  https://github.com/hashicorp/terraform/issues/7221
  vpc_security_group_ids = ["${aws_security_group.backend_server.id}"]
  key_name               = "${aws_key_pair.deployer.key_name}"

  //user_data = "${file(\"cloud-config/app.yml\")}"
  tags = {
    Name = "backend_server-${count.index}"
  }
}

resource "aws_instance" "jumpBox" {
  count         = 1
  ami           = "${lookup(var.amis, var.region)}"
  instance_type = "t2.micro"
  subnet_id     = "${aws_subnet.public.id}"

  //security_groups             = ["${aws_security_group.ssh_anywhere.id}"] https://github.com/hashicorp/terraform/issues/7221
  vpc_security_group_ids = ["${aws_security_group.ssh_anywhere.id}"]

  key_name                    = "${aws_key_pair.deployer.key_name}"
  associate_public_ip_address = true

  //user_data = "${file(\"cloud-config/app.yml\")}"
  tags = {
    Name = "jumpBox-${count.index}"
  }
}
