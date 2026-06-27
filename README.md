# Cenário 1 - Sistema de Clínica Veterinária

## Tabelas

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
    especie VARCHAR(100) NOT NULL,
    raca VARCHAR(100) NOT NULL,
    tutor_id INTEGER NOT NULL,
    FOREIGN KEY (tutor_id) REFERENCES tutor(id)
);
```

### Consulta

```sql
CREATE TABLE consulta (
    id SERIAL PRIMARY KEY,
    animal_id INTEGER NOT NULL,
    data DATE NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES animal(id)
);
```

## Regras de Negócio

* Cadastrar tutores com nome, endereço e telefone.
* Um tutor pode ter um ou mais animais cadastrados.
* Todo animal deve estar vinculado a um tutor.
* Cadastrar animais com nome, espécie e raça.
* Registrar consultas para animais cadastrados.
* Cada consulta deve informar o animal, a data, o motivo e o valor.
* Não é permitido registrar consulta para um animal que não esteja cadastrado.
* O valor da consulta não pode ser negativo.
* O sistema deve permitir consultar o histórico de consultas de um animal.
* O sistema deve permitir consultar todos os animais de um tutor.
* O fluxo do sistema deve seguir a ordem: Tutor → Animal → Consulta.
