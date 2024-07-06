import React, { useEffect, useState } from "react";
import { appleList,deleteProduct } from "../Service/Appleservice";
import { useNavigate } from "react-router-dom";

const Productslist = () => {
  const navigation = useNavigate();
  const [apples, setApples] = useState([]);
  
  useEffect(()=>{
    listapples();
  },[])
  function listapples() {
   
    appleList().then((response) => {
      setApples(response.data);
    })
  }

  function addnewproduct() {
    navigation("/addproduct")
  }
  const updateproduct=(id)=>{
    navigation(`/editproduct/${id}`)
  }
  const deleteProduct=(id)=>{
   
   deleteProduct(id).then((response)=>{
    listapples();
   })
  }

  return (
    <div className="container">
      <h1 className="text-center">Apple products</h1>
      <button className="btn-btn-info" onClick={addnewproduct}>
        Addnewproducts
      </button>
      <div>
        <table className="center">
          <thead>
            <tr>
              {/* <th>Model Id:</th> */}
              <th> ModelName:</th>
              <th> Price: </th>
              <th>View/Delete</th>
            </tr>
          </thead>
          <tbody>
            {
            apples.map(apple => 
              <tr key={apple.id}>
                {/* <td>{apple.id}</td> */}
                <td>{apple.modelname}</td>
                <td>{apple.price}</td>
                <td>
                  <button
                    className="btn-btn-info"
                    onClick={() => updateproduct(apple.id)}
                  >
                    View&Update
                  </button>
                </td>
                <td>
                  <button
                    className="btn-btn-inf"
                    onClick={() => deleteProduct(apple.id)}
                  >
                  Delete
                  </button>
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}
export default Productslist;