import './Home.css'
import MultiItemCarousel from './MultiItemCarousel';

const Home = () => {
    return (
        <div>
            <section className='banner -z-50 relative flex flex-col justify-center items-center'>
                <div className="w-[50vw] z-10 text-center">
                    <h3 className="text-2xl z-10 lg:text-6xl font-bold  py-15">FastFood</h3>
                    <p className="z-10 text-gray-300 text-xl lg:text-4xl">Experimente o prazer: comida rápida e entrega</p>
                </div>
                <div className="cover absolute top-0 left-0 right-0">

                </div>
                <div className='faout'>

                </div>
            </section>
            <section className='p-10 lg:py-10 lg:px-20'>
                <p className='text-2xl font-semibold text-gray-500 py-3 pb-10 justify-center '>Top Refeições</p>
                <MultiItemCarousel />
            </section>

            <section className='px-5 lg:px-20'>
                <h1 className='text-2xl font-semibold text-white px-3'>Encomende dos seus favoritos escolhidos</h1>
            </section>
        </div>
    )
}

export default Home;