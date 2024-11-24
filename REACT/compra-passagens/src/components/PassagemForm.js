import React, { useState } from 'react';
import axios from 'axios';

const destinos = ["Rio de Janeiro", "Arraial do Cabo-RJ", "Belo Horizonte-MG", "Goiania-GO"];

const PassagemForm = ({ adicionarPassagem }) => {
  const [nome, setNome] = useState('');
  const [cpf, setCpf] = useState('');
  const [origem, setOrigem] = useState('');
  const [destino, setDestino] = useState(destinos[0]);
  const [assento, setAssento] = useState('');
  const [dataIda, setDataIda] = useState('');
  const [horarioIda, setHorarioIda] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();

    const passagem = {
      nome,
      cpf,
      origem,
      destino,
      assento,
      dataIda,
      horarioIda
    };

    try {
      const response = await axios.post('http://localhost:8080/passagens', passagem);
      adicionarPassagem(response.data);
      // Limpar o formulário após o envio
      setNome('');
      setCpf('');
      setOrigem('');
      setAssento('');
      setDataIda('');
      setHorarioIda('');
    } catch (error) {
      console.error("Erro ao adicionar passagem:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Nome:</label>
        <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} required />
      </div>
      <div>
        <label>CPF:</label>
        <input type="text" value={cpf} onChange={(e) => setCpf(e.target.value)} required />
      </div>
      <div>
        <label>Origem:</label>
        <input type="text" value={origem} onChange={(e) => setOrigem(e.target.value)} required />
      </div>
      <div>
        <label>Destino:</label>
        <select value={destino} onChange={(e) => setDestino(e.target.value)}>
          {destinos.map((dest, index) => (
            <option key={index} value={dest}>{dest}</option>
          ))}
        </select>
      </div>
      <div>
        <label>Número do Assento:</label>
        <input type="number" value={assento} onChange={(e) => setAssento(e.target.value)} required />
      </div>
      <div>
        <label>Data de Ida:</label>
        <input type="date" value={dataIda} onChange={(e) => setDataIda(e.target.value)} required />
      </div>
      <div>
        <label>Horário de Ida:</label>
        <input type="time" value={horarioIda} onChange={(e) => setHorarioIda(e.target.value)} required />
      </div>
      <button type="submit">Comprar Passagem</button>
    </form>
  );
};

export default PassagemForm;
