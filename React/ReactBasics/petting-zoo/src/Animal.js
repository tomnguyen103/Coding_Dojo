import React from 'react';

const Animal = (props) => {
    return (
        <div className="animal card">
            <h2>{props.name}</h2>
            <hr></hr>
            <button onClick={()=> props.onPetAnimal(props.name)} className="btn btn-primary">{`Pet the ${props.name}`}</button>
        </div>
    )
}

export default Animal;