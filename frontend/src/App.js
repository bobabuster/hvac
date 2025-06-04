import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import BrandsPage from './components/BrandsPage';
import ModelLinePage from './components/ModelLinePage';
import ModelVariantPage from './components/ModelVariantPage';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<BrandsPage />} />
        <Route path="/brand/:brandName" element={<ModelLinePage />} />
        <Route path="/brand/:brandName/model-line/:modelLineName" element={<ModelVariantPage />} />
      </Routes>
    </Router>
  );
}

export default App;
