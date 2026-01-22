import { useState } from 'react'
import ServiceNote from '../src/components/ServiceNote.tsx'
import ServiceNote from '../src/components/ServiceNote.tsx'
import ServiceCostMemo from '../src/components/ServiceCostMemo.tsx'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <ServiceNote />
      <ServiceCostMemo />
    </>
  )
}

export default App
