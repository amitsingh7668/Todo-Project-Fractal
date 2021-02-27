import "./todoapp.css";
import React, { useState, useEffect } from "react";
import Axios from 'axios';
import 'react-dropdown/style.css';

export function TodoApp() {
  const [task, setTask] = useState("");
  const [tasklist, setTaskList] = useState([]);
  const todoBackEndUrl = "http://localhost:8081/user/";
  
  useEffect(() =>{
    Axios.get(todoBackEndUrl+"tasks").then(a => 
    {
        setTaskList(a.data.data);
    })
  },[])

  const handleChange = (e) => {
    setTask(e.target.value);
  };

  const AddTask = () => {
    Axios.post(todoBackEndUrl+"tasks/"+task).then(a => 
    {
        setTaskList(a.data.data);
    })
  };

  const deletetask = (e, id) => {
    Axios.delete(todoBackEndUrl+"Deletetask/"+id).then(a => 
    {
        setTaskList(a.data.data);
    })
  };


  const updateStatus = (e, id) => {
    Axios.put(todoBackEndUrl+"UpdateStatus/"+id).then(a => 
    {
        setTaskList(a.data.data);
    })
  };

  const updateTaskBucket = (e, id) => {
    Axios.put(todoBackEndUrl+"taskStatus/"+id+"/"+e.target.value).then(a => 
    {
        setTaskList(a.data.data);
    })
};

const series = ( id) => {
   return id+1;
};

const DropDown = (t) => {
   return <> 
   Category - 
        <select value={t.category} className="DropDown" onChange={(e) =>updateTaskBucket(e,t.id)} >
                        <option value="A">TODO</option>
                        <option value="B">IN PROGRESS</option>
                        <option value="C">DONE</option>
        </select>
        </>
};

  return (
    <div className="todo">
        <h1 style={{color:"black"}}> Welcome Here's your TODO list</h1>
      <input type="text" name="text" id="text" onChange={(e) => handleChange(e)}placeholder="Add task here..."/>
      <button className="add-btn" onClick={() =>AddTask()}>Add Task</button>
      <br />
      {tasklist !== [] ? (
        <ul>
          {tasklist.map((t, index) => (
            <li >
          <div className="list" style={{height:"10%"}} key={index}>
            <h3>Task ({series(index)})-{t.task}</h3>
          </div>
             <button className="delete" onClick={(e) => deletetask(e, t.id)}>
                Remove Task From List
              </button>

              {t.status==="COMPLETED" ? (<button className="completed" onClick={(e) => updateStatus(e, t.id)}>
                {t.status}
              </button>):null}

              {t.status==="NOT COMPLETED" ? (<button className="notcompleted" onClick={(e) => updateStatus(e, t.id)}>
                {t.status}
              </button>):null}
              {DropDown(t)}
            </li>
          ))}
        </ul>
      ) : null}
    </div>
  );
}