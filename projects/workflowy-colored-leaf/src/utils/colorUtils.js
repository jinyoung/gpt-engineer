export function computeNodeColor(importance, createdAt) {
  const importanceColor = getImportanceColor(importance);
  const ageColor = getAgeColor(createdAt);
  return blendColors(importanceColor, ageColor);
}

function getImportanceColor(importance) {
  // Logic to determine color based on importance
}

function getAgeColor(createdAt) {
  // Logic to determine color based on age
}

function blendColors(color1, color2) {
  // Logic to blend two colors
}