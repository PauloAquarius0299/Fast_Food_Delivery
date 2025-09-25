import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import Navbar from './components/Navbar.jsx'
import darkTheme from './utils/DarkTheme.js'
import { CssBaseline, ThemeProvider } from '@mui/material'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <ThemeProvider theme={darkTheme}>
      <CssBaseline />
      <Navbar />
    <App />
    </ThemeProvider>
  </StrictMode>,
)
