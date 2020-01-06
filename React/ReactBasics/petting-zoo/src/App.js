import React, {Component} from 'react';
import Animal from './Animal';

class App extends Component{
    constructor(props){
        super(props);
        this.state = {
            message: ""
        }
    }
    handleMessage(name){
        const newMessage = `You just pet the ${name}`;
        this.setState({message: newMessage});
    }

    render(){
        return(
            <div className="container">
                <h1>Petting Zoo!</h1>
                <h3>{this.state.message}</h3>
                <div className="jumbotron">
                    <Animal name="Horse" onPetAnimal={(name)=>this.handleMessage(name)} />
                    <Animal name="Goat" onPetAnimal={(name)=>this.handleMessage(name)} />
                    <Animal name="Sheep" onPetAnimal={(name)=>this.handleMessage(name)} />
                    <Animal name="Mouse" onPetAnimal={(name)=>this.handleMessage(name)} />
                </div>
            </div>
        )
    }
}

export default App;