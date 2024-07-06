import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Productslist from "./components/Productslist";
import Product from "./components/Product";
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Productslist />}></Route>
          <Route path='/product' element={<Productslist />}></Route>
          <Route path='/addproduct' element={<Product />}></Route>
          <Route path='/editproduct/:id' element={<Product />}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;