import ReactDOM from 'react-dom';
import React from 'react';

import HelloJS from './components/HelloJS'

const props = {
    title: "Angular",
    description: "JavaScript framework for building user interfaces"
}

ReactDOM.render(<HelloJS title="React" description="JavaScript library for building user interfaces" />, document.getElementById("root"));