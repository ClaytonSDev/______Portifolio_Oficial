import React from 'react';

const PassagemList = ({ passagens }) => {
  return (
    <div>
      <h2>Lista de Passagens</h2>
      {passagens.length === 0 ? (
        <p>Nenhuma passagem disponível.</p>
      ) : (
        <ul>
          {passagens.map((passagem, index) => (
            <li key={index}>
              <p><strong>Nome:</strong> {passagem.nome}</p>
              <p><strong>CPF:</strong> {passagem.cpf}</p>
              <p><strong>Origem:</strong> {passagem.origem}</p>
              <p><strong>Destino:</strong> {passagem.destino}</p>
              <p><strong>Assento:</strong> {passagem.assento}</p>
              <p><strong>Data de Ida:</strong> {passagem.dataIda}</p>
              <p><strong>Horário de Ida:</strong> {passagem.horarioIda}</p>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default PassagemList;
