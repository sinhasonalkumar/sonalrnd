consul agent -server -bootstrap-expect 1 -data-dir /tmp/consul -bind 127.0.0.1

vault server --config=vault.conf

export VAULT_ADDR=http://127.0.0.1:8200
vault init


vault unseal
	enter Unseal Key 1

vault unseal
	enter Unseal Key 2

vault unseal
	enter Unseal Key 3


vault auth [Initial Root Token]



------
vault.conf
-----

backend "consul" {
  address = "127.0.0.1:8500"
  path = "vault"
}

listener "tcp" {
 address = "127.0.0.1:8200"
 tls_disable = 1
}