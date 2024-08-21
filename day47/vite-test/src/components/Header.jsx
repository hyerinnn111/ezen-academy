import logoImg from "../assets/soup.jpg";

export default function Header() {
  return (
    <header id="main-header">
      <div id="title">
        <img src={logoImg} alt="레스토랑" />
        <h1>음식점</h1>
      </div>
      <nav>
        <button>cart (0)</button>
      </nav>
    </header>
  );
}
