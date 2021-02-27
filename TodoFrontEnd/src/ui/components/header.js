import React from 'react'
import { Header, Image } from 'semantic-ui-react'

export function  HeaderExampleImage()
{
    return  (
  <Header as='h2'>
    Devloper :-
    <Image circular src='https://react.semantic-ui.com/images/avatar/large/patrick.png'  
  loading="lazy"
  width="30"
  height="30"/> Amit Singh 
  </Header>
);

    }

    
