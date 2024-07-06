import axios from "axios";

const APPLE_URL = "http://localhost:8080/api/v1/apple";

export const appleList = () => {
  return axios.get(APPLE_URL);
};
export const createproduct = (product) => {
  return axios.post(APPLE_URL, product);
};
export const getproduct = (productid) => {
  return axios.get(APPLE_URL + "/" + productid);
};
export const updateproduct = (productid, product) => {
  return axios.put(APPLE_URL + "/" + productid, product);
};
export const deleteProduct =(id)=>{
  return axios.delete(APPLE_URL+'/'+id)
}