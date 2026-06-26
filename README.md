# Sistema de Escola de Cursos Livres - Cenário 3

## Descrição do Sistema

Sistema desenvolvido para gerenciamento de uma escola de cursos livres, permitindo o cadastro de alunos, cursos e matrículas. O sistema garante controle de vagas e evita matrículas duplicadas.

---

## Tabelas do Banco de Dados

### Tabela: aluno

- id (PK) - Identificador único
- nome - Nome do aluno
- email - Email do aluno (único)
- telefone - Telefone do aluno

---

### Tabela: curso

- id (PK) - Identificador único
- nome - Nome do curso
- descricao - Descrição do curso
- carga_horaria - Carga horária do curso
- vagas_totais - Número total de vagas
- vagas_disponiveis - Número de vagas disponíveis

---

### Tabela: matricula

- id (PK) - Identificador único
- id_aluno (FK) - Referência ao aluno
- id_curso (FK) - Referência ao curso
- data_matricula - Data da matrícula
- valor - Valor pago na matrícula

---

##  Regras de Negócio

- Um aluno não pode ser cadastrado duas vezes no mesmo curso.
- Não é permitido matricular um aluno em um curso que não exista.
- Não é permitido matricular um aluno que não esteja cadastrado.
- O valor da matrícula não pode ser negativo.
- Não é permitido matricular em cursos sem vagas disponíveis.
- Cada matrícula reduz automaticamente uma vaga do curso.
- A matrícula depende obrigatoriamente de um aluno e de um curso válidos.

---

## Movimento do Sistema

A matrícula representa o relacionamento entre aluno e curso, sendo validada pelo sistema antes de ser persistida no banco de dados.