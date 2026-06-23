# Cenário 1 - Clínica Veterinária

## Entidades

### Tutor

* id
* nome
* endereco
* telefone

### Animal

* id
* nome
* especie
* raca
* tutor_id

### Consulta

* id
* animal_id
* data
* motivo
* valor

## Regras de Negócio

1. Um tutor pode possuir vários animais.
2. Um animal pertence a um único tutor.
3. Não é permitido registrar consulta para um animal não cadastrado.
4. O valor da consulta não pode ser negativo.
5. O sistema deve permitir consultar o histórico de consultas de um animal.
6. O sistema deve permitir visualizar todos os animais de um tutor.

## CREATE TABLE

### Tutor

```sql
CREATE TABLE tutor (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(200) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);
```

### Animal

```sql
CREATE TABLE animal (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raca VARCHAR(100) NOT NULL,
    tutor_id INT NOT NULL,
    FOREIGN KEY (tutor_id) REFERENCES tutor(id)
);
```

### Consulta

```sql
CREATE TABLE consulta (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    motivo VARCHAR(200) NOT NULL,
    animal_id INT NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animal(id)
);
```
