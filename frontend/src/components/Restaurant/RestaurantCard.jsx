import { Card, Chip, IconButton } from '@mui/material'
import {Heart, HeartPlus} from 'lucide-react'

const RestaurantCard = () => {
  return (
    <Card className='w-[18rem]'>
      <div className={`${true?'cursor-pointer': 'cursor-not-allowed'} relative`}>
        <img 
        className='w-full h-[10rem] rounded-t-md object-cover'
        src='https://images.pexels.com/photos/2159074/pexels-photo-2159074.jpeg?_gl=1*1cabua3*_ga*MTA3MTQzMjY1MC4xNzU1MDA0MzY3*_ga_8JE65Q40S6*czE3NTg4MDM0NTEkbzgkZzEkdDE3NTg4MDM0ODQkajI3JGwwJGgw'
        alt='card images'
        />
        <Chip 
        size='small'
        className='absolute top-2 left-2'
        color={true?'success':'error'}
        label={true?'open':'closed'}
        />
      </div>
      <div className='p-4 textPart lg:flex w-full justify-between'>
        <div className='space-y-1'>
          <p className='font-semibold text-lg'>Asian Fast Delicias</p>
          <p className='text-gray-500 text-sm'>
            Com vontade de tudo? Mergulhe no nosso universo global...
          </p>
        </div>
        <div>
          <IconButton>
            {true?<Heart />:<HeartPlus />}
          </IconButton>
        </div>
      </div>
    </Card>
  )
}

export default RestaurantCard