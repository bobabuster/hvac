import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate, Link } from 'react-router-dom';
import './Card.css';

export default function ModelLinePage() {
  const { brandName } = useParams();
  const decodedBrandName = decodeURIComponent(brandName);
  const [modelLines, setModelLines] = useState([]);
  const navigate = useNavigate();

  const API_BASE_URL = process.env.REACT_APP_API_URL || 'http://localhost:8080';

  useEffect(() => {
    axios
      .get(`${API_BASE_URL}/api/hvac/brands/${encodeURIComponent(decodedBrandName)}/model-lines`)
      .then((res) => setModelLines(res.data))
      .catch((err) => {
        console.error(err);
        navigate('/'); 
      });
  }, [decodedBrandName, navigate, API_BASE_URL]);

  return (
    <div className="page-container">
      <h1>Model Lines for {decodedBrandName}</h1>
      {modelLines.length === 0 ? (
        <p>No model lines found for this brand.</p>
      ) : (
        <div className="card-grid">
          {modelLines.map((line) => (
            <div key={line.name} className="item-block">
              <h2>{line.name}</h2>
              <p>{line.variants.length} Variants</p>
              <Link
                to={`/brand/${encodeURIComponent(decodedBrandName)}/model-line/${encodeURIComponent(line.name)}`}
                className="card-link"
              >
                View Variants →
              </Link>
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
