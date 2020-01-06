import React from 'react';

const HelloJS = (props) => {

    return (
        <div className="jumbotron">
            <h1>Hello {props.title}</h1>
            <p>{props.title} is {props.description} </p>
        </div>
    )
}

export default HelloJS;