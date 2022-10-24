import React, {useState} from "react";
import {soustrait} from "../utils/BackendCalls";

const Soustraction = () => {
        const [numOne,setNumOne] = useState(0)
        const [numTwo,setNumTwo] = useState(0)
        const [result,setResult] = useState(0)

        const submit = async (e) => {
            e.preventDefault()
            const result = await soustrait(numOne,numTwo)
            setResult(result)
        }
        return (
            <>
                <form onSubmit={submit}>
                    <label>One</label>
                    <input type="number" data-testid="SubNumOne" onChange={(e) => {setNumOne(e.target.value)}}/>
                    <label>Two</label>
                    <input type="number" data-testid="SubNumTwo" onChange={(e) => {setNumTwo(e.target.value)}}/>
                    <input type="submit" data-testid="SubButton" value={"Soustrait"}/>
                </form>

                <h1>{result}</h1>
            </>
        )
}
export default Soustraction