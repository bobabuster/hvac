import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';
import './Card.css';

export default function BrandsPage() {
  const [brands, setBrands] = useState([]);
  const [searchResults, setSearchResults] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    axios
      .get('http://localhost:8080/api/hvac/brands')
      .then((res) => setBrands(res.data))
      .catch(console.error);
  }, []);

  const handleSearchChange = (e) => {
    const keyword = e.target.value;
    setSearchTerm(keyword);

    if (keyword.trim() === '') {
      setSearchResults([]);
      return;
    }

    axios
      .get(`http://localhost:8080/api/hvac/search?keyword=${encodeURIComponent(keyword)}`)
      .then((res) => setSearchResults(res.data))
      .catch(console.error);
  };

  const handleResultClick = (result) => {
    if (result.type === 'brand') {
      navigate(`/brand/${encodeURIComponent(result.name)}`);
    } else if (result.type === 'modelLine') {
      navigate(`/brand/${encodeURIComponent(result.brand)}/model-line/${encodeURIComponent(result.name)}`);
    } else if (result.type === 'modelVariant') {
      // Redirect to model line page, using variant's line and brand
      navigate(`/brand/${encodeURIComponent(result.brand)}/model-line/${encodeURIComponent(result.line)}`);
    }
  };
  
  

  return (
    <div className="page-container">
      <h1>HVAC Brands</h1>

      <input
        type="text"
        placeholder="Search brands and model lines..."
        value={searchTerm}
        onChange={handleSearchChange}
        className="search-input"
      />

      {searchResults.length > 0 && (
        <div className="search-results">
          {searchResults.map((result, index) => (
            <div
              key={index}
              className="search-result-item"
              onClick={() => handleResultClick(result)}
              style={{ cursor: 'pointer', padding: '8px', borderBottom: '1px solid #ccc' }}
            >
              {result.type === 'brand' ? (
                <strong>Brand: {result.name}</strong>
              ) : (
                <span>
                  Model Line: {result.name} <em>({result.brand})</em>
                </span>
              )}
            </div>
          ))}
        </div>
      )}

      <div>
        {brands.map((brand) => (
          <div key={brand.name} className="item-block">
            <h2>{brand.name}</h2>
            <p>{brand.modelLines.length} Model Lines</p>
            <Link to={`/brand/${encodeURIComponent(brand.name)}`} className="card-link">
              View Model Lines →
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
}
