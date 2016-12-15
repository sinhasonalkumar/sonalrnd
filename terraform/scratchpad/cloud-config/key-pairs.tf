resource "aws_key_pair" "deployer" {
  key_name   = "deployer-key"
  public_key = "${file("/Users/sonal/sonal/gitlocalrepository/terraform/scratchpad/ssh/insecure-deployer.pub")}"
}
