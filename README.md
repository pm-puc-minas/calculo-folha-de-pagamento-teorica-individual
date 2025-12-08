# Sistema de Folha de Pagamento
Aluno: Matheus Balsamão Ferreira
Projeto completo com **backend em Spring Boot** e **frontend em React (Vite)**.

## Como rodar

### Backend

Requisitos: Java 17, Maven.

```bash
cd backend
mvn spring-boot:run
```

O backend sobe em `http://localhost:8080`.

Usuário padrão: `admin` / senha: `admin`.

### Frontend

Requisitos: Node 18+.

```bash
cd frontend
npm install
npm run dev
```

O frontend sobe em `http://localhost:5173` e já está configurado para chamar o backend.

---

## Funcionalidades

- Autenticação via HTTP Basic (login/senha).
- Cadastro de funcionários.
- Cálculo de:
  - salário/hora,
  - periculosidade,
  - insalubridade,
  - VT,
  - VA,
  - INSS,
  - FGTS,
  - IRRF,
  - salário líquido.
- Padrões de projeto:
  - Strategy (cálculos),
  - Factory (seleção das estratégias),
  - uso de eventos Spring para cadastro e geração de folha.
- Persistência em banco H2 em memória.
- Teste unitário de exemplo para cálculo de INSS.
