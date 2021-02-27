import React from 'react';
import './App.css';
import { Switch, Route } from 'react-router';
import { BrowserRouter } from 'react-router-dom';
import {TodoApp} from "../src/ui/components/toDoList/TodoAllTask"


function App() {
  return (
    <BrowserRouter>
    <div className="App">
      <div className = "container">
          <Switch>            
            <Route from = '*' component={TodoApp}/>
          </Switch>
        </div>
    </div>
    </BrowserRouter>
  );
}

export default App;
