import React from 'react';
import { Button, Input } from '@mui/material';
import './App.css';

function App() {
  const onSubmit = (data: LoginForm) => apiCall(data);

  return (
    <div className="App">
      <Input></Input>
      <Button type="submit" fullWidth>
        Submit
      </Button>
    </div>
  );
}

export default App;
