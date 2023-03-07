import logo from './logo.svg';
import './App.css';
import { BrowserRouter } from 'react-router-dom';
import { ShoppingCartRoutes } from './routes/Routes';
function App() {
  return (
    <BrowserRouter>
      <ShoppingCartRoutes />
    </BrowserRouter>
  );
}

export default App;
