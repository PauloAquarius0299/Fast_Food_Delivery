import {Search, UserRound, ShoppingCart} from 'lucide-react';
const Navbar = () => {
  return (
    <div className='px-5 z-50 py-[.8rem] bg-amber-500 lg:px-20 flex justify-between'>
      <div className='flex items-center space-x-4'>
        <div className='lg:mr-10 cursor-pointer flex items-center space-x-4'>
          <h2 className='logo font-semibold text-white text-2xl'>
            FastFood
          </h2>
        </div>

        
      </div>

      <div className='flex items-center space-x-2 lg:space-x-10'>
          <div>
            <button className='cursor-pointer'>
              <Search />
            </button>
          </div>
          <div>
            <button className="w-12 h-12 flex items-center justify-center border-white rounded-full shadow cursor-pointer">
              <UserRound />
            </button>
          </div>
          <div>
            <button className='cursor-pointer'><ShoppingCart /></button>
          </div>
        </div>
    </div>
  )
}

export default Navbar