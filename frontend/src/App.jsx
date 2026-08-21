import { useEffect, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [task, setTask] = useState([])

  useEffect(() => {
      fetch('http://localhost:9000/tasks').then(response=>response.json()).then(data=>setTask(data));
  }, [])
  
  return (
    <>
      <div
        className='bg-gray-200'
      >
        <h1>
          Task Manager
        </h1>
        
        <div>
            {
              task.map(task=>(
                <div
                  key={task.id}
                >
                  <h2>
                     {task.tilte}
                  </h2>
                  <p>
                    {
                      task.completed ? "Completed":"Pending"
                    }
                  </p>
                </div>
              ))
            }
        </div>

      </div>
    </>
  )
}

export default App
