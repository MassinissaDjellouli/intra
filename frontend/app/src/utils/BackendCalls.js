export const additionne = async (numOne,numTwo) => {
    const req = await fetch("http://localhost:8080/Additionne",
        {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                a: numOne,
                b: numTwo
            })
        })
    if(!req.ok){
        if(req.status === 400){
            alert("Votre chiffre est trop grand")
        }else{
            alert("euh? une erreur?")
        }
        return 0;
    }
    const data = await req.json()
    return data.result
}

export const soustrait = async (numOne,numTwo) => {
    const req = await fetch("http://localhost:8080/Soustrait",
        {
            method: "POST",
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                a: numOne,
                b: numTwo
            })
        })
    if(!req.ok){
        if(req.status === 400){
            alert("Votre chiffre est trop grand")
        }else{
            alert("euh? une erreur?")
        }
        return 0;
    }
    const data = await req.json()
    return data.result
}