import React, { useState } from 'react'

function Login({ onLogin }) {
  const [username, setUsername] = useState('admin')
  const [password, setPassword] = useState('admin')
  const [error, setError] = useState(null)

  const handleSubmit = async (e) => {
    e.preventDefault()
    const token = btoa(username + ':' + password)
    try {
      const resp = await fetch('/api/auth/check', {
        headers: {
          'Authorization': 'Basic ' + token
        }
      })
      if (!resp.ok) {
        setError('Usuário ou senha inválidos')
        return
      }
      onLogin(username, password)
    } catch (err) {
      setError('Erro ao conectar com o servidor')
    }
  }

  return (
    <div style={{ padding: '40px', fontFamily: 'sans-serif' }}>
      <h1>Login - Folha de Pagamento</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Usuário: </label>
          <input value={username} onChange={e => setUsername(e.target.value)} />
        </div>
        <div>
          <label>Senha: </label>
          <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
        </div>
        <button type="submit">Entrar</button>
      </form>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <p>Usuário padrão: <b>admin</b> / Senha: <b>admin</b></p>
    </div>
  )
}

export default Login
