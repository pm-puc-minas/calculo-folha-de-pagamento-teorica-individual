import React, { useEffect, useState } from 'react'

function FuncionariosPage({ auth }) {
  const [lista, setLista] = useState([])
  const [form, setForm] = useState({
    nome: '',
    cpf: '',
    salarioBase: 3000,
    horasDia: 8,
    diasMes: 22,
    recebePericulosidade: false,
    recebeInsalubridade: false,
    grauInsalubridade: 'MINIMO',
    usaValeTransporte: true,
    valorVT: 200,
    usaValeAlimentacao: true,
    valorVA: 500
  })

  const headers = {
    'Content-Type': 'application/json',
    'Authorization': 'Basic ' + auth.token
  }

  const carregar = async () => {
    const resp = await fetch('/api/funcionarios', { headers })
    const data = await resp.json()
    setLista(data)
  }

  useEffect(() => {
    carregar()
  }, [])

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target
    setForm(prev => ({
      ...prev,
      [name]: type === 'checkbox' ? checked : value
    }))
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    await fetch('/api/funcionarios', {
      method: 'POST',
      headers,
      body: JSON.stringify({
        ...form,
        salarioBase: parseFloat(form.salarioBase),
        valorVT: parseFloat(form.valorVT),
        valorVA: parseFloat(form.valorVA)
      })
    })
    setForm(prev => ({ ...prev, nome: '', cpf: '' }))
    carregar()
  }

  return (
    <div style={{ flex: 1 }}>
      <h2>Funcionários</h2>
      <form onSubmit={handleSubmit}>
        <div><input placeholder="Nome" name="nome" value={form.nome} onChange={handleChange} /></div>
        <div><input placeholder="CPF" name="cpf" value={form.cpf} onChange={handleChange} /></div>
        <div><input placeholder="Salário base" name="salarioBase" value={form.salarioBase} onChange={handleChange} /></div>
        <div><input placeholder="Horas/dia" name="horasDia" value={form.horasDia} onChange={handleChange} /></div>
        <div><input placeholder="Dias/mês" name="diasMes" value={form.diasMes} onChange={handleChange} /></div>
        <div>
          <label><input type="checkbox" name="recebePericulosidade" checked={form.recebePericulosidade} onChange={handleChange} /> Periculosidade</label>
        </div>
        <div>
          <label><input type="checkbox" name="recebeInsalubridade" checked={form.recebeInsalubridade} onChange={handleChange} /> Insalubridade</label>
          <select name="grauInsalubridade" value={form.grauInsalubridade} onChange={handleChange}>
            <option value="MINIMO">Mínimo</option>
            <option value="MEDIO">Médio</option>
            <option value="MAXIMO">Máximo</option>
          </select>
        </div>
        <div>
          <label><input type="checkbox" name="usaValeTransporte" checked={form.usaValeTransporte} onChange={handleChange} /> Vale Transporte</label>
          <input placeholder="Valor VT" name="valorVT" value={form.valorVT} onChange={handleChange} />
        </div>
        <div>
          <label><input type="checkbox" name="usaValeAlimentacao" checked={form.usaValeAlimentacao} onChange={handleChange} /> Vale Alimentação</label>
          <input placeholder="Valor VA" name="valorVA" value={form.valorVA} onChange={handleChange} />
        </div>
        <button type="submit">Salvar funcionário</button>
      </form>

      <h3>Lista</h3>
      <ul>
        {lista.map(f => (
          <li key={f.id}>{f.nome} - R$ {f.salarioBase}</li>
        ))}
      </ul>
    </div>
  )
}

export default FuncionariosPage
