// ========================
// Bar color palette
// ========================
const COLORS = [
    'linear-gradient(180deg, #00ffe0, #00b8a0)',
    'linear-gradient(180deg, #ff3f6c, #b02848)',
    'linear-gradient(180deg, #ffe040, #b89e00)',
    'linear-gradient(180deg, #a78bfa, #6d28d9)',
    'linear-gradient(180deg, #34d399, #059669)',
    'linear-gradient(180deg, #f97316, #c2410c)',
    'linear-gradient(180deg, #60a5fa, #2563eb)',
    'linear-gradient(180deg, #f472b6, #be185d)',
];

// Format large numbers: 1,392,730,000 → "1.39B"
function fmtPop(n) {
    if (n >= 1e9) return (n / 1e9).toFixed(2) + 'B';
    if (n >= 1e6) return (n / 1e6).toFixed(2) + 'M';
    if (n >= 1e3) return (n / 1e3).toFixed(1) + 'K';
    return n.toLocaleString();
}

// ========================
// Fetch data from Java server
// ========================
async function loadData() {
    const barDiv = document.getElementById('barChart');
    barDiv.innerHTML = '<p class="status">Fetching from Java server...</p>';
    document.getElementById('lineCard').style.display = 'none';
    document.getElementById('statsRow').style.display = 'none';

    let countries;

    try {
        const res = await fetch('http://localhost:8080/data');
        if (!res.ok) throw new Error('HTTP ' + res.status);
        countries = await res.json();
    } catch (e) {
        barDiv.innerHTML = `<p class="status error">&#9888; Could not reach Java server &mdash; make sure Server.java is running on port 8080.<br><small>${e.message}</small></p>`;
        return;
    }

    if (!countries || countries.length === 0) {
        barDiv.innerHTML = '<p class="status error">&#9888; Server returned no data.</p>';
        return;
    }

    renderBarChart(countries);
    renderLineChart(countries);
    renderStats(countries);
}

// ========================
// Bar Chart
// ========================
function renderBarChart(countries) {
    const max        = Math.max(...countries.map(c => c.value));
    const GRID_STEPS = 5;
    const stepVal    = Math.ceil(max / GRID_STEPS);
    const chartMax   = stepVal * GRID_STEPS;

    // Gridlines
    let gridHTML = '<div class="gridlines">';
    for (let i = GRID_STEPS; i >= 0; i--) {
        gridHTML += `<div class="gridline"><span>${fmtPop(i * stepVal)}</span></div>`;
    }
    gridHTML += '</div>';

    // Bars
    let barsHTML = '';
    countries.forEach((c, i) => {
        const pct   = (c.value / chartMax) * 100;
        const delay = (i * 0.05).toFixed(2);
        barsHTML += `
      <div class="bar-group">
        <div class="bar"
          data-value="${fmtPop(c.value)}"
          style="height:${pct}%;background:${COLORS[i % COLORS.length]};animation-delay:${delay}s">
        </div>
        <div class="bar-label">${c.name}</div>
      </div>`;
    });

    document.getElementById('barChart').innerHTML = `
    <div class="chart-area">${gridHTML}${barsHTML}</div>
    <div class="x-axis"></div>
  `;
}

// ========================
// Line Chart (SVG)
// ========================
function renderLineChart(countries) {
    document.getElementById('lineCard').style.display = 'block';
    const svg   = document.getElementById('lineChart');
    const W     = 760, H = 200, PAD = 20;
    const max   = Math.max(...countries.map(c => c.value)) * 1.1;
    const count = countries.length;

    const xs = countries.map((_, i) =>
        count === 1 ? W / 2 : PAD + (i / (count - 1)) * (W - PAD * 2)
    );
    const ys = countries.map(c =>
        H - PAD - (c.value / max) * (H - PAD * 2)
    );

    const pathD = xs.map((x, i) => `${i === 0 ? 'M' : 'L'} ${x} ${ys[i]}`).join(' ');
    const areaD = pathD + ` L ${xs[count - 1]} ${H} L ${xs[0]} ${H} Z`;

    const dots = countries.map((c, i) =>
        `<circle class="dot" cx="${xs[i]}" cy="${ys[i]}" r="5"><title>${c.name}: ${fmtPop(c.value)}</title></circle>`
    ).join('');

    svg.innerHTML = `
    <defs>
      <linearGradient id="areaGrad" x1="0" y1="0" x2="0" y2="1">
        <stop offset="0%"   stop-color="#ff3f6c" stop-opacity="1"/>
        <stop offset="100%" stop-color="#ff3f6c" stop-opacity="0"/>
      </linearGradient>
    </defs>
    <path class="area-path" d="${areaD}"/>
    <path class="line-path"  d="${pathD}"/>
    ${dots}
  `;
}

// ========================
// Stats Row
// ========================
function renderStats(countries) {
    const values     = countries.map(c => c.value);
    const sum        = values.reduce((a, b) => a + b, 0);
    const avg        = sum / values.length;
    const max        = Math.max(...values);
    const min        = Math.min(...values);
    const maxCountry = countries.find(c => c.value === max).name;
    const minCountry = countries.find(c => c.value === min).name;

    const items = [
        { label: 'Countries',   value: countries.length,  color: '#00ffe0' },
        { label: 'Smallest',    value: minCountry,        color: '#60a5fa' },
        { label: 'Population',  value: fmtPop(min),       color: '#60a5fa' },
        { label: 'Largest',     value: maxCountry,        color: '#ff3f6c' },
        { label: 'Population',  value: fmtPop(max),       color: '#ff3f6c' },
        { label: 'Average',     value: fmtPop(avg),       color: '#ffe040' },
        { label: 'Total',       value: fmtPop(sum),       color: '#34d399' },
    ];

    document.getElementById('stats').innerHTML = items.map(s => `
    <div class="stat">
      <div class="stat-label">${s.label}</div>
      <div class="stat-value" style="color:${s.color}">${s.value}</div>
    </div>
  `).join('');

    document.getElementById('statsRow').style.display = 'block';
}

// Auto-run on page load
loadData();