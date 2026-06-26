# Cenário 2 — Sistema de Oficina Mecânica

## Entidades identificadas

### cliente
Campos:
- id
- nome
- telefone

### veiculo
Campos:
- id
- placa
- modelo
- ano
- id_cliente

### ordem_servico
Campos:
- id
- id_veiculo
- descricao
- valor
- status

## Regras de negócio

1. Um cliente pode ter mais de um veículo.
2. Um veículo pertence a um cliente.
3. Uma ordem de serviço pertence a um veículo.
4. Não pode abrir ordem de serviço para veículo não cadastrado.
5. O valor do serviço não pode ser negativo.
6. Deve ser possível consultar o histórico de manutenções de um veículo.

## Comandos SQL

CREATE TABLE cliente (
id SERIAL PRIMARY KEY,
nome VARCHAR(100) NOT NULL,
telefone VARCHAR(20) NOT NULL
);

CREATE TABLE veiculo (
id SERIAL PRIMARY KEY,
placa VARCHAR(10) NOT NULL,
modelo VARCHAR(100) NOT NULL,
ano INT NOT NULL,
id_cliente INT NOT NULL,
FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE ordem_servico (
id SERIAL PRIMARY KEY,
id_veiculo INT NOT NULL,
descricao VARCHAR(255) NOT NULL,
valor NUMERIC(10,2) NOT NULL CHECK (VALOR >= 0),
status VARCHAR(20) NOT NULL,
FOREIGN KEY (id_veiculo) REFERENCES veiculo(id)
);

## Fluxo simulado na Main

cliente → veículo → ordem de serviço