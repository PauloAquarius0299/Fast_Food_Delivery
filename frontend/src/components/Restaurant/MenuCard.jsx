import { Accordion, AccordionDetails, AccordionSummary, FormControlLabel, FormGroup, Checkbox, Button } from '@mui/material'
import { CirclePlus } from 'lucide-react'
import React from 'react'


const demo = [
     {
        category: 'Nuts and seeds',
        ingredients: ['Cashews'],
    },
    {
        category: 'Protein',
        ingredients: ['Protein', 'Bread', 'Bacon strips']
    }
]

const MenuCard = () => {
    const handleCheckBoxChange=(value)=>{
        console.log('value');
    }
  return (
    <Accordion>
        <AccordionSummary
        expandIcon={<CirclePlus />}
        aria-controls='painel'
        id='painel'
        >
            <div className='lg:flex items-center justify-between'>
                <div className='lg:flex items-center lg:gap-5'>
                    <img 
                    className='w-[7rem] h-[7rem] object-cover'
                    src='https://images.pexels.com/photos/410648/pexels-photo-410648.jpeg?_gl=1*g2tnlf*_ga*MTA3MTQzMjY1MC4xNzU1MDA0MzY3*_ga_8JE65Q40S6*czE3NTg4ODY1NzckbzExJGcxJHQxNzU4ODg2NTg0JGo1MyRsMCRoMA..' alt='image food' />
                    <div className='space-y-1 lg:space-y-5 lg:max-w-2xl'>
                        <p className='font-semibold text-xl'>Costela de carneiro</p>
                        <p>89,99</p>
                        <p className='text-gray-400'>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Eius molestiae.</p>
                    </div>
                </div>
            </div>
        </AccordionSummary>
        <AccordionDetails>
            <form>
                <div className='flex gap-5 flex-wrap'>
                   {demo.map((item, index) => (
                    <div key={index} className="min-w-[200px]">
                        <p className="font-medium">{item.category}</p>
                        <FormGroup>
                        {item.ingredients.map((ingredient, i) => (
                            <FormControlLabel
                            key={i}
                            control={<Checkbox defaultChecked />}
                            label={ingredient}
                            />
                        ))}
                        </FormGroup>
                    </div>
                    ))}
                </div>
                <div>
                    <Button
                    variant='contained'
                    disabled={false}
                    type='submit'
                    >{true?"Add ao carrinho": 'Fora de estoque'}</Button>
                </div>
            </form>
        </AccordionDetails>
    </Accordion>
  )
}

export default MenuCard