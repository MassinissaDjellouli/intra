import React, {useState} from "react";
import {additionne} from "../utils/BackendCalls"
const Addition = () => {
    const [numOne,setNumOne] = useState(0)
    const [numTwo,setNumTwo] = useState(0)
    const [result,setResult] = useState(0)

    const submit = async (e) => {
        e.preventDefault()
        const result = await additionne(numOne,numTwo)
        setResult(result)
    }
    return (
       <>
           <form onSubmit={submit}>
               <label>One</label>
               <input type="number" data-testid="AddNumOne" onChange={(e) => {setNumOne(e.target.value)}}/>
               <label>Two</label>
               <input type="number" data-testid="AddNumTwo" onChange={(e) => {setNumTwo(e.target.value)}}/>
               <input type="submit" data-testid="AddButton" value={"Additionne"}/>
           </form>

           <h1>{result}</h1>
       </>
   )
}
export default Addition