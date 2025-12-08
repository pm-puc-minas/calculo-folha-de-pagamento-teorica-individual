import React, { useState } from 'react'
import Login from './components/Login'
import FuncionariosPage from './components/FuncionariosPage'
import FolhaPage from './components/FolhaPage'

function App() {
  const [auth, setAuth] = useState(() => {
    const stored = localStorage.getItem('auth')
    return stored ? JSON.parse(stored) : null
  })

  const handleLogin = (username, password) => {
    const token = btoa(username + ':' + password)
    setAuth({ username, token })
    localStorage.setItem('auth', JSON.stringify({ username, token }))
  }

  const handleLogout = () => {
    setAuth(null)
    localStorage.removeItem('auth')
  }

  if (!auth) {
    return <Login onLogin={handleLogin} />
  }

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>Folha de Pagamento</h1>
      <p>Usuário logado: {auth.username} <button onClick={handleLogout}>Sair</button></p>
      <div style={{ display: 'flex', gap: '40px' }}>
        <FuncionariosPage auth={auth} />
        <FolhaPage auth={auth} />
      </div>
    </div>
  )
}

export default App
