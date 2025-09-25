import React from 'react'

const CarouselItem = ({image, title}) => {
  return (
    <div className='flex flex-col justify-center items-center'>
        <img className='w-[10rem] h-[10rem] lg:h-[4rem]lg:w-[14rem] rounded-full object-cover object-center' src={image} alt='images foods' />
        <span className='py-5 font-semibold text-xl text-gray-400'>{title}</span>
    </div>
  )
}

export default CarouselItem