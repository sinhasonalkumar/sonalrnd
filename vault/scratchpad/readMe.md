consul agent -server -bootstrap-expect 1 -data-dir /tmp/consul -bind 127.0.0.1

vault server --config=vault.conf

export VAULT_ADDR=http://127.0.0.1:8200
vault init

vault status

vault unseal
	enter Unseal Key 1

vault unseal
	enter Unseal Key 2

vault unseal
	enter Unseal Key 3

vault status

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

----

sonal@sonal-2  ~/sonal/gitlocalrepository/vault  master ● ?  vault init                                            ✓  370  12:08:23
Unseal Key 1: pxgHKCjjW3phaBAh99IzrxkpSiOi4dTxRp0lF3NKyfcB
Unseal Key 2: uyP72ro2IfjSI751JsTSzKc8wRJF4aeKBiowLKbLrRoC
Unseal Key 3: vu53QH8yI6++t7EkP++azp+v60bVaxxHr1FnctEiRxsD
Unseal Key 4: 3OW8ZXYXQmu0xIzQoDTW4MN3wKT3RkaXkI1rynDBO6AE
Unseal Key 5: 2Sgw/7MTQDzYUIOBuR+e4vvk6vBnzP1aOfY8lAco0aEF
Initial Root Token: 6bd65870-08dc-b12a-f086-ba4437b6758e

Vault initialized with 5 keys and a key threshold of 3. Please
securely distribute the above keys. When the Vault is re-sealed,
restarted, or stopped, you must provide at least 3 of these keys
to unseal it again.

Vault does not store the master key. Without at least 3 keys,
your Vault will remain permanently sealed.
