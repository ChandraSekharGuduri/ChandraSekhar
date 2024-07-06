import React, { useEffect, useState } from "react";
import { createproduct,getproduct,updateproduct } from "../Service/Appleservice";
import { useNavigate, useParams } from "react-router-dom";

const Product = () => {
  const [modelname, setmodelname] = useState('');
  const [price, setprice] = useState('');
//   const [id,setid]=useState('');

  
  const handlemodelname = (e) => {
    setmodelname(e.target.value);
  }
  const handleprice = (e) => {
    setprice(e.target.value);
  }
//   const handleid=(e)=>{
//     setid(e.target.value);
//   }
const {id}=useParams();
  const navigation = useNavigate();
  useEffect(()=>{
    if(id){
        getproduct(id).then((response)=>{
        //   setid(response.data.id)
            setmodelname(response.data.modelname);
            setprice(response.data.price);
        })
    }
  },[id])

  function saveproduct(e) {
    e.preventDefault();
  const product = {id, modelname, price };
  console.log(product)

    if(id){
        updateproduct(id, product).then((response) => {
          console.log(response.d);
          navigation('/');
        })
    }else{
       createproduct(product).then((response)=>{
            console.log(response.data)
            navigation('/')
        })
    }

   
  }
  function Title(){
    if(id){
        return(<h1 className="text-center">Update-Product</h1>)
    }else{
        return(<h1 className="text-center">Create-Product</h1>)
    }
  }
  return (
    <div className="container">
      {Title()}
      <br></br>
      {/* <div className="form-data">
        <label className="form-label">Id:</label>
        <input
          type="text"
          placeholder="Enter the Id"
          name="id"
          value={id}
          onChange={handleid}
        ></input>
      </div> */}
      <div className="form-data">
        <label className="form-label">modelname:</label>
        <input
          type="text"
          placeholder="Enter the modelname"
          name="modelname"
          value={modelname}
          onChange={handlemodelname}
        ></input>
      </div>
      <div className="form-data">
        <label className="form-label">Price</label>
        <input
          type="text"
          placeholder="Please check the price"
          name="price"
          value={price}
          onChange={handleprice}
        ></input>
      </div>
      <button className="btn-btn-success" onClick={saveproduct}>
        Submit
      </button>
    </div>
  );
}
export default Product;