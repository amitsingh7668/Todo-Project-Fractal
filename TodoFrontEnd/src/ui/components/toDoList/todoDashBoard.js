import React, { useState, useEffect } from "react";
import '../../../../src/ui/components/login.css';
// import {Board} from './dashboardComponent';
import Axios from 'axios';

import {HeaderExampleImage} from '../header';
import {Todotask} from "../toDoList/toDoTask"


export function Tododashboard() {
  const [name, setName] = useState("");
  const [password, setpassword] = useState("");
  const [test, settest] = useState("");
  const [todolist, settodolist] = useState([]);
  
  useEffect(() =>{
    // window.sessionStorage.setItem("check",JSON.stringify(({"amit":"singh"})))
    Axios.get("http://localhost:8081/user/tasks").then(a => 
    {
        settodolist(a.data.data);
        
    })
  },[])

  function valid() {
    
    return name.length>0 && password.length>0;   
  }

  function create()
  {
          window.open(
          'create','_self'
          
        )
      // }
  }
  window.sessionStorage.setItem("check",({"amit":"singh"}))

  function val()
  {
    Axios.get("http://localhost:8080/app/t1/login/"+name+"/"+password)
      .then(res => {
        const persons = res.data.data;
        console.log(persons)
        
        if(persons!=="invalid")
        {
          settest(persons)
          window.open(
            '/doc','_self'
            
          )
         
        }
        else
        {
          alert("invalid")
        }
      })
  }
  
  
  const handleSubmit = (evt) => {
    val()
      evt.preventDefault();
      // // alert(`Submitting Name ${name}`)
      // if(name==="amit" && password==="singh")
      // {
      //   window.open(
      //     '/doc','_self'
          
      //   )
      // }
      // else
      // {
      //   alert("You not an authorized user \n Please try again later")
      // }
  }


  return (
    <div className = "toDoList">
      <h1>ToDo Task List For The Day</h1>
      <div className="users">
        {todolist.map((user, index) => (
          <div key={index}>
            <h3>{user.task}</h3>
            <p>{user.status}</p>
            <p>{user.category}</p>
            <Todotask props={user}/>
          </div>
        ))}
        
      </div>
    </div>
  );
}