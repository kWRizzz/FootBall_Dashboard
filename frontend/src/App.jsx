import { useEffect, useState } from 'react'

function App() {
  const [task, setTask] = useState([])
  const [error, setError] = useState(null)

  useEffect(() => {
      fetch('http://localhost:9000/task')
        .then(response => {
          if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
          }
          return response.json();
        })
        .then(data => setTask(data))
        .catch(err => {
          console.error("Failed to fetch tasks:", err);
          setError(err.message);
        });
  }, [])
  
  return (
    <>
      <div
        className='bg-gray-200'
      >
        <h1>
          Task Manager
        </h1>

        {error && <p style={{color: 'red'}}>Error: {error}</p>}
        
        <div>
            {
              task.map(t => (
                <div
                  key={t.id}
                >
                  <h2>
                     {t.title}
                  </h2>
                  <p>
                    {
                      t.completed ? "Completed" : "Pending"
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
