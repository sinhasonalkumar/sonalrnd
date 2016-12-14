variable "access_key" {
  description = "AWS access key"
  default = ""
}

variable "secret_key" {
  description = "AWS secret access key"
  default = ""
}

variable "shared_credentials_file" {
  description = "AWS credentials path where credentials with profile are listed "
  default = ""
}

variable "profile" {
  description = "AWS credentials profile"
  //default = "sonal-rnd"
}

variable "region"     {
  description = "AWS region to host your network"
  default     = "us-west-2"
}

variable "vpc_cidr" {
  description = "CIDR for VPC"
  default     = "10.0.0.0/16"
}

variable "public_subnet_cidr" {
  description = "CIDR for public subnet"
  default     = "10.0.1.0/24"
}

variable "private_subnet_cidr" {
  description = "CIDR for private subnet"
  default     = "10.0.11.0/24"
}

/* Amazon Linux AMI 2016.09.0 (HVM), SSD Volume Type By  Region */
variable "amis" {
  description = "Base AMI to launch the instances with"
  default = {
    us-west-2 = "ami-5ec1673e"
    us-east-1 = "ami-b73b63a0"
  }
}
