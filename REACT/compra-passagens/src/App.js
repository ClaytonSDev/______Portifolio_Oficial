import React, { useState } from 'react';
import PassagemForm from './components/PassagemForm';
import PassagemList from './components/PassagemList'; // Certifique-se de que o caminho está correto

function App() {
  const [passagens, setPassagens] = useState([]);

  const adicionarPassagem = (passagem) => {
    setPassagens([...passagens, passagem]);
  };

  return (
    <div className="App">
      <h1>Sistema de Compra de Passagens</h1>
      <PassagemForm adicionarPassagem={adicionarPassagem} />
      <PassagemList passagens={passagens} />
    </div>
  );
}

export default App;
