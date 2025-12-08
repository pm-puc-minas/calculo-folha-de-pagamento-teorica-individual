import React, { useState, useEffect } from 'react'

function FolhaPage({ auth }) {
  const [funcionarios, setFuncionarios] = useState([])
  const [selecionado, setSelecionado] = useState('')
  const [mes, setMes] = useState(5)
  const [ano, setAno] = useState(2024)
  const [folha, setFolha] = useState(null)

  const headers = {
    'Authorization': 'Basic ' + auth.token
  }

  useEffect(() => {
    const carregar = async () => {
      const resp = await fetch('/api/funcionarios', { headers })
      const data = await resp.json()
      setFuncionarios(data)
      if (data.length > 0) setSelecionado(data[0].id)
    }
    carregar()
  }, [])

  const gerar = async () => {
    const params = new URLSearchParams({
      funcionarioId: selecionado,
      mes,
      ano
    })
    const resp = await fetch('/api/folha/gerar?' + params.toString(), {
      method: 'POST',
      headers
    })
    const data = await resp.json()
    setFolha(data)
  }

  return (
    <div style={{ flex: 1 }}>
      <h2>Folha de Pagamento</h2>
      <div>
        <select value={selecionado} onChange={e => setSelecionado(e.target.value)}>
          {funcionarios.map(f => (
            <option key={f.id} value={f.id}>{f.nome}</option>
          ))}
        </select>
      </div>
      <div>
        <input type="number" value={mes} onChange={e => setMes(e.target.value)} /> Mês
        <input type="number" value={ano} onChange={e => setAno(e.target.value)} /> Ano
      </div>
      <button onClick={gerar}>Gerar folha</button>

      {folha && (
        <div style={{ marginTop: '20px', border: '1px solid #ccc', padding: '10px' }}>
          <h3>Relatório</h3>
          <p>Funcionário: <b>{folha.nomeFuncionario}</b></p>
          <p>Referência: {folha.mes}/{folha.ano}</p>
          <p>Salário base: R$ {folha.salarioBase}</p>
          <p>Salário hora: R$ {folha.salarioHora}</p>
          <p>Periculosidade: R$ {folha.periculosidade}</p>
          <p>Insalubridade: R$ {folha.insalubridade}</p>
          <p>INSS: R$ {folha.inss}</p>
          <p>IRRF: R$ {folha.irrf}</p>
          <p>FGTS: R$ {folha.fgts}</p>
          <p>Vale transporte: R$ {folha.vt}</p>
          <p>Vale alimentação: R$ {folha.va}</p>
          <p><b>Salário bruto: R$ {folha.salarioBruto}</b></p>
          <p><b>Salário líquido: R$ {folha.salarioLiquido}</b></p>
        </div>
      )}
    </div>
  )
}

export default FolhaPage
