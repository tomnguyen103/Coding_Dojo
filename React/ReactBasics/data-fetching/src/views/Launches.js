import React from 'react'
import { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from '@reach/router';


export default () =>{
    const [launches, setLaunches] = useState([]);

    useEffect(()=>{
        axios.get('https://api.spacexdata.com/v3/launches')
        .then(console.log)
        .catch()
    }, []);

    return launches.map(launch => {
        <div key={launch.flight_number}>
            <Link to={'/launches/' + launch.flight_number}></Link>
            <h2>{launch.mission_name}</h2>

        </div>
    })
}