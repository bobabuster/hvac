import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import './Card.css';

export default function ModelVariantPage() {
  const { brandName, modelLineName } = useParams();
  const decodedBrandName = decodeURIComponent(brandName);
  const decodedModelLineName = decodeURIComponent(modelLineName);

  const [variants, setVariants] = useState([]);
  const navigate = useNavigate();

  const API_BASE_URL = 'https://nosohvac.onrender.com';


  useEffect(() => {
    axios
      .get(
        `${API_BASE_URL}/api/hvac/brands/${encodeURIComponent(decodedBrandName)}/model-lines/${encodeURIComponent(decodedModelLineName)}/variants`
      )
      .then((res) => setVariants(res.data))
      .catch((err) => {
        console.error(err);
        navigate('/'); 
      });
  }, [decodedBrandName, decodedModelLineName, navigate, API_BASE_URL]);

  return (
    <div className="page-container">
      <h1>
        Variants for {decodedModelLineName} ({decodedBrandName})
      </h1>
  
      {variants.length > 0 && (
        <div className="card-grid">
          {variants.map((variant) => (
            <div key={variant.name} className="item-block">
              <h2>{variant.name || 'N/A'}</h2>
              <p>Voltage: {variant.voltage || 'N/A'}</p>
              <p>Phase: {variant.phase || 'N/A'}</p>
              {variant.url && variant.url.trim() !== '' ? (
                <a
                  href={variant.url}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="card-link"
                >
                  View Product
                </a>
              ) : (
                <p>No URL available</p>
              )}
            </div>
          ))}
        </div>
      )}
  
      <button className="back-button" onClick={() => navigate(-1)}>
        Back
      </button>
    </div>
  );  
}
