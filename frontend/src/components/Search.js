import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function Search() {
  const [keyword, setKeyword] = useState('');
  const [results, setResults] = useState([]);
  const navigate = useNavigate();

  const handleSearch = async (e) => {
    e.preventDefault();
    if (!keyword.trim()) {
      setResults([]);
      return;
    }
    try {
      const res = await axios.get(`http://localhost:8080/api/hvac/search?keyword=${encodeURIComponent(keyword)}`);
      setResults(res.data);
    } catch (err) {
      console.error(err);
      setResults([]);
    }
  };

  const handleResultClick = (result) => {
    if (result.type === 'brand') {
      navigate(`/brand/${encodeURIComponent(result.name)}`);
    } else if (result.type === 'model') {
      navigate(`/brand/${encodeURIComponent(result.brand)}/category/${encodeURIComponent(result.category)}/models`);
    }
  };

  return (
    <div className="search-container">
      <form onSubmit={handleSearch}>
        <input
          type="text"
          placeholder="Search brands and models..."
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
          style={{ padding: '8px', width: '300px', marginRight: '8px' }}
        />
        <button type="submit">Search</button>
      </form>

      <ul style={{ listStyle: 'none', padding: 0, marginTop: '16px' }}>
        {results.map((result, index) => (
          <li
            key={index}
            onClick={() => handleResultClick(result)}
            style={{
              cursor: 'pointer',
              padding: '10px',
              border: '1px solid #ccc',
              marginBottom: '8px',
              borderRadius: '6px',
              backgroundColor: result.type === 'brand' ? '#e6f7ff' : '#fff',
            }}
          >
            {result.type === 'brand' ? (
              <strong>Brand: {result.name || 'N/A'}</strong>
            ) : (
              <>
                <strong>Model: {result.name || 'N/A'}</strong><br />
                <small>
                  Brand: {result.brand || 'N/A'} | Category: {result.category || 'N/A'}
                </small>
              </>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
}
