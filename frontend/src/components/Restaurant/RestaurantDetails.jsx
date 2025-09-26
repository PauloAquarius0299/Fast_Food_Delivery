import { Clock, MapPin } from "lucide-react";
import { FormControl, FormControlLabel, Radio, RadioGroup, Typography } from "@mui/material";
import { useState } from "react";
import MenuCard from "./MenuCard";

const categories = [
  "italiano",
  "brasileiro",
  "burger",
  "churrasco",
  "gelados",
  "sobremesa",
  "japonesa",
  "asiatica",
  "mexicana",
  "mediteranea",
  "arabe",
  "pizza",
];

const foodTypeOptions = [
  { label: "Todos", value: "all" },
  { label: "Vegetariano", value: "vegetarian" },
  { label: "Churrasco", value: "barbecue" },
  { label: "Doces", value: "candies" },
  { label: "Cafe da manhã", value: "breakfast" },
];

const menu =[1,1,1,1,1,1];

const RestaurantDetails = () => {
  const [selectedFoodType, setSelectedFoodType] = useState("all");
  const [selectedCategory, setSelectedCategory] = useState("");

  const handleFilter = (e) => {
    const { name, value } = e.target;
    if (name === "food_types") setSelectedFoodType(value);
    if (name === "categories") setSelectedCategory(value);
    console.log("filter", name, value);
  };

  return (
    <div className="px-5 lg:px-20">
      <section>
        <h3 className="text-gray-500 py-2 mt-10">Home/brazilian/brazilian foods/3</h3>

        {/* Imagens (mantive seu layout) */}
        <div className="grid gap-4">
          <img
            className="block w-full h-[60vh] object-cover rounded-lg"
            src="https://images.pexels.com/photos/5999249/pexels-photo-5999249.jpeg"
            alt="principal"
          />

          <div className="grid grid-cols-2 md:grid-cols-2 gap-4">
            <img
              className="block w-full h-[40vh] object-cover rounded-lg"
              src="https://images.pexels.com/photos/236887/pexels-photo-236887.jpeg"
              alt="1"
            />
            <img
              className="block w-full h-[40vh] object-cover rounded-lg"
              src="https://images.pexels.com/photos/11209052/pexels-photo-11209052.jpeg"
              alt="2"
            />
          </div>

          <div className="grid grid-cols-2 md:grid-cols-2 gap-4">
            <img
              className="block w-full h-[40vh] object-cover rounded-lg"
              src="https://images.pexels.com/photos/5490830/pexels-photo-5490830.jpeg"
              alt="3"
            />
            <img
              className="block w-full h-[40vh] object-cover rounded-lg"
              src="https://images.pexels.com/photos/1267315/pexels-photo-1267315.jpeg"
              alt="4"
            />
          </div>
        </div>

        <div className="pt-3 pb-5">
          <h1 className="text-4xl font-semibold">Fast Food Brasileiro–Churraso</h1>
          <div className="flex items-center gap-2 text-gray-400 my-2">
            <Clock />
            <span> Quarta a Dom: 9h00 AM - 00h No (hoje)</span>
          </div>
          <p className="text-white mt-1">Lorem ipsum dolor sit...</p>
          <div className="flex items-center gap-2 text-gray-400 my-2">
            <MapPin />
            <span>Rua centro Belo Horizonte / Belo Horizonte</span>
          </div>
        </div>
      </section>

      <section className="p-[2rem] lg:flex relative">
        <div className="space-y-10 lg:w-[20%] filter">
          <div className="box space-y-5 lg:sticky top-28 shadow-md p-5">
            <div>
              <Typography variant="h5" sx={{ paddingBottom: "1rem" }}>
                Tipo de Comida
              </Typography>

              <FormControl className="py-10 space-y-5" component={"fieldset"}>
                <RadioGroup
                  onChange={handleFilter}
                  name="food_types"
                  value={selectedFoodType}
                >
                  {foodTypeOptions.map((item) => (
                    <FormControlLabel
                      key={item.value}
                      value={item.value}
                      control={<Radio />}
                      label={item.label}
                    />
                  ))}
                </RadioGroup>
              </FormControl>
            </div>

            <div>
              <Typography variant="h5" sx={{ paddingBottom: "1rem" }}>
                Categoria
              </Typography>

              <FormControl className="py-10 space-y-5" component={"fieldset"}>
                <RadioGroup
                  onChange={handleFilter}
                  name="categories"
                  value={selectedCategory}
                >
                  {categories.map((item) => (
                    <FormControlLabel
                      key={item}
                      value={item}
                      control={<Radio />}
                      label={item}
                    />
                  ))}
                </RadioGroup>
              </FormControl>
            </div>
          </div>
        </div>

        <div className="space-y-10 lg:w-[80%] lg:pl-10">
          {menu.map((item) => <MenuCard />)}
        </div>
      </section>
    </div>
  );
};

export default RestaurantDetails;
